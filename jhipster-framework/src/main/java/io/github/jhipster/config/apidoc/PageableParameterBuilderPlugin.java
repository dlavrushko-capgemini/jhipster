package io.github.jhipster.config.apidoc;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.service.ResolvedMethodParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import java.util.ArrayList;
import java.util.List;

public class PageableParameterBuilderPlugin implements OperationBuilderPlugin {

    public static final String DEFAULT_PAGE_NAME = "page";

    public static final String PAGE_DESCRIPTION = "Page number of the requested page";

    public static final String DEFAULT_SIZE_NAME = "size";

    public static final String SIZE_DESCRIPTION = "Size of a page";

    public static final String DEFAULT_SORT_NAME = "sort";

    public static final String SORT_DESCRIPTION = "Sorting criteria in the format: property(,asc|desc). "
            + "Default sort order is ascending. "
            + "Multiple sort criteria are supported.";

    private final ResolvedType pageableType;

    public PageableParameterBuilderPlugin(TypeResolver resolver) {
        this.pageableType = resolver.resolve(Pageable.class);
    }

    @Override
    public void apply(OperationContext context) {
        List<RequestParameter> parameters = new ArrayList<>();
        for (ResolvedMethodParameter methodParameter : context.getParameters()) {
            ResolvedType resolvedType = methodParameter.getParameterType();

            if (pageableType.equals(resolvedType)) {
                parameters.add(createPageParameter());
                parameters.add(createSizeParameter());
                parameters.add(createSortParameter());

                context.operationBuilder().requestParameters(parameters);
            }
        }
    }

    protected RequestParameter createPageParameter() {
        return new RequestParameterBuilder()
            .name(getPageName())
            .in(ParameterType.QUERY)
            .query(p -> p.model(m -> m.scalarModel(ScalarType.INTEGER)))
            .description(PAGE_DESCRIPTION)
            .build();
    }

    protected RequestParameter createSizeParameter() {
        return new RequestParameterBuilder()
            .name(getSizeName())
            .in(ParameterType.QUERY)
            .query(p -> p.model(m -> m.scalarModel(ScalarType.INTEGER)))
            .description(SIZE_DESCRIPTION)
            .build();
    }

    protected RequestParameter createSortParameter() {
        return new RequestParameterBuilder()
            .name(getSortName())
            .in(ParameterType.QUERY)
            .query(p -> p.model(m -> m.collectionModel(
                cm -> cm.model(m2 -> m2.scalarModel(ScalarType.STRING)))))
            .description(SORT_DESCRIPTION)
            .build();
    }

    protected String getPageName() {
        return DEFAULT_PAGE_NAME;
    }

    protected String getSizeName() {
        return DEFAULT_SIZE_NAME;
    }

    protected String getSortName() {
        return DEFAULT_SORT_NAME;
    }

    @Override
        public boolean supports(DocumentationType delimiter) {
            return DocumentationType.OAS_30.equals(delimiter);
        }
}