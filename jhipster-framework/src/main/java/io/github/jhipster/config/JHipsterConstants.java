package io.github.jhipster.config;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.annotation.RestResource;

public interface JHipsterConstants {

    // Spring profiles for development, test and production, see https://www.jhipster.tech/profiles/
    /** Constant <code>SPRING_PROFILE_DEVELOPMENT="dev"</code> */
    String SPRING_PROFILE_DEVELOPMENT = "dev";
    /** Constant <code>SPRING_PROFILE_TEST="test"</code> */
    String SPRING_PROFILE_TEST = "test";
    /** Constant <code>SPRING_PROFILE_PRODUCTION="prod"</code> */
    String SPRING_PROFILE_PRODUCTION = "prod";
    /** Spring profile used when deploying with Spring Cloud (used when deploying to CloudFoundry)
        Constant <code>SPRING_PROFILE_CLOUD="cloud"</code> */
    String SPRING_PROFILE_CLOUD = "cloud";
    /** Spring profile used when deploying to Heroku
        Constant <code>SPRING_PROFILE_HEROKU="heroku"</code> */
    String SPRING_PROFILE_HEROKU = "heroku";
    /** Spring profile used when deploying to Amazon ECS
        Constant <code>SPRING_PROFILE_AWS_ECS="aws-ecs"</code> */
    String SPRING_PROFILE_AWS_ECS = "aws-ecs";
    /** Spring profile used when deploying to Microsoft Azure
        Constant <code>SPRING_PROFILE_AZURE="azure"</code> */
    String SPRING_PROFILE_AZURE = "azure";
    /** Spring profile used to enable OpenAPI doc generation
        Constant <code>SPRING_PROFILE_API_DOCS="api-docs"</code> */
    String SPRING_PROFILE_API_DOCS = "api-docs";
    /** Spring profile used to disable running liquibase
        Constant <code>SPRING_PROFILE_NO_LIQUIBASE="no-liquibase"</code> */
    String SPRING_PROFILE_NO_LIQUIBASE = "no-liquibase";
    /** Spring profile used when deploying to Kubernetes and OpenShift
        Constant <code>SPRING_PROFILE_K8S="k8s"</code> */
    String SPRING_PROFILE_K8S = "k8s";
}