/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.metadata.rest.springmvc;

import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.common.utils.JsonUtils;
import org.apache.dubbo.metadata.rest.ClassPathServiceRestMetadataReader;
import org.apache.dubbo.metadata.rest.DefaultRestService;
import org.apache.dubbo.metadata.rest.PathMatcher;
import org.apache.dubbo.metadata.rest.RestMethodMetadata;
import org.apache.dubbo.metadata.rest.RestService;
import org.apache.dubbo.metadata.rest.ServiceRestMetadata;
import org.apache.dubbo.metadata.rest.StandardRestService;
import org.apache.dubbo.metadata.rest.api.SpringControllerService;
import org.apache.dubbo.metadata.rest.api.SpringRestService;
import org.apache.dubbo.metadata.rest.api.SpringRestServiceImpl;
import org.apache.dubbo.rpc.model.ApplicationModel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * {@link SpringMvcServiceRestMetadataResolver} Test
 *
 * @since 2.7.9
 */
class SpringMvcServiceRestMetadataResolverTest {

    private SpringMvcServiceRestMetadataResolver instance = new SpringMvcServiceRestMetadataResolver(ApplicationModel.defaultModel());

    @Test
    void testSupports() {
        // Spring MVC RestService class
        assertTrue(instance.supports(SpringRestService.class, true));
        // JAX-RS RestService class
        assertFalse(instance.supports(StandardRestService.class, true));
        // Default RestService class
        assertFalse(instance.supports(DefaultRestService.class, true));
        // No annotated RestService class
        assertFalse(instance.supports(RestService.class, true));
        // null
        assertFalse(instance.supports(null, true));
    }

    @Test
    @Disabled
    void testResolve() {
        // Generated by "dubbo-metadata-processor"
        ClassPathServiceRestMetadataReader reader = new ClassPathServiceRestMetadataReader("META-INF/dubbo/spring-mvc-service-rest-metadata.json");
        List<ServiceRestMetadata> serviceRestMetadataList = reader.read();

        ServiceRestMetadata expectedServiceRestMetadata = serviceRestMetadataList.get(0);
        ServiceRestMetadata serviceRestMetadata = instance.resolve(SpringRestService.class);

        assertTrue(CollectionUtils.equals(expectedServiceRestMetadata.getMeta(), serviceRestMetadata.getMeta()));

        assertEquals(expectedServiceRestMetadata, serviceRestMetadata);

    }

    @Test
    void testResolves() {
        testResolve(SpringRestService.class);
        testResolve(SpringRestServiceImpl.class);
        testResolve(SpringControllerService.class);
    }

    void testResolve(Class service) {
        List<String> jsons = Arrays.asList(
            "{\"argInfos\":[{\"annotationNameAttribute\":\"b\",\"formContentType\":false,\"index\":0,\"paramAnnotationType\":\"org.apache.dubbo.metadata.rest.tag.ParamTag\",\"paramName\":\"b\",\"paramType\":\"java.lang.Integer\",\"urlSplitIndex\":0}],\"codeStyle\":\"org.apache.dubbo.metadata.rest.springmvc.SpringMvcServiceRestMetadataResolver\",\"indexToName\":{0:[\"b\"]},\"method\":{\"annotations\":[],\"parameters\":[]},\"request\":{\"consumes\":[\"*/*\"],\"headerNames\":[],\"headers\":{},\"method\":\"POST\",\"paramNames\":[],\"params\":{},\"path\":\"/noAnnoNumber\",\"produces\":[\"*/*\"]}}",
            "{\"argInfos\":[{\"annotationNameAttribute\":\"c\",\"formContentType\":false,\"index\":0,\"paramAnnotationType\":\"org.apache.dubbo.metadata.rest.tag.ParamTag\",\"paramName\":\"c\",\"paramType\":\"int\",\"urlSplitIndex\":0}],\"codeStyle\":\"org.apache.dubbo.metadata.rest.springmvc.SpringMvcServiceRestMetadataResolver\",\"indexToName\":{0:[\"c\"]},\"method\":{\"annotations\":[],\"parameters\":[]},\"request\":{\"consumes\":[\"*/*\"],\"headerNames\":[],\"headers\":{},\"method\":\"POST\",\"paramNames\":[],\"params\":{},\"path\":\"/noAnnoPrimitive\",\"produces\":[\"*/*\"]}}",
            "{\"argInfos\":[{\"annotationNameAttribute\":\"a\",\"formContentType\":false,\"index\":0,\"paramAnnotationType\":\"org.apache.dubbo.metadata.rest.tag.ParamTag\",\"paramName\":\"a\",\"paramType\":\"java.lang.String\",\"urlSplitIndex\":0}],\"codeStyle\":\"org.apache.dubbo.metadata.rest.springmvc.SpringMvcServiceRestMetadataResolver\",\"indexToName\":{0:[\"a\"]},\"method\":{\"annotations\":[],\"parameters\":[]},\"request\":{\"consumes\":[\"text/plain\"],\"headerNames\":[],\"headers\":{},\"method\":\"POST\",\"paramNames\":[],\"params\":{},\"path\":\"/noAnnoParam\",\"produces\":[\"text/plain\"]}}",
            "{\"argInfos\":[{\"annotationNameAttribute\":\"\",\"formContentType\":false,\"index\":0,\"paramAnnotationType\":\"org.springframework.web.bind.annotation.PathVariable\",\"paramName\":\"a\",\"paramType\":\"java.lang.String\",\"urlSplitIndex\":2}],\"codeStyle\":\"org.apache.dubbo.metadata.rest.springmvc.SpringMvcServiceRestMetadataResolver\",\"indexToName\":{0:[\"a\"]},\"method\":{\"annotations\":[],\"parameters\":[]},\"request\":{\"consumes\":[\"application/x-www-form-urlencoded\"],\"headerNames\":[],\"headers\":{},\"method\":\"POST\",\"paramNames\":[],\"params\":{},\"path\":\"/pathVariable/{a}\",\"produces\":[\"application/x-www-form-urlencoded\"]}}",
            "{\"argInfos\":[{\"annotationNameAttribute\":\"user\",\"formContentType\":false,\"index\":0,\"paramAnnotationType\":\"org.springframework.web.bind.annotation.RequestBody\",\"paramName\":\"user\",\"paramType\":\"org.apache.dubbo.metadata.rest.User\",\"urlSplitIndex\":0}],\"codeStyle\":\"org.apache.dubbo.metadata.rest.springmvc.SpringMvcServiceRestMetadataResolver\",\"indexToName\":{0:[\"user\"]},\"method\":{\"annotations\":[],\"parameters\":[]},\"request\":{\"consumes\":[\"application/json\"],\"headerNames\":[],\"headers\":{},\"method\":\"POST\",\"paramNames\":[],\"params\":{},\"path\":\"/body\",\"produces\":[\"application/json\"]}}",
            "{\"argInfos\":[{\"annotationNameAttribute\":\"param\",\"defaultValue\":\"{0}\",\"formContentType\":false,\"index\":0,\"paramAnnotationType\":\"org.springframework.web.bind.annotation.RequestParam\",\"paramName\":\"param\",\"paramType\":\"java.lang.String\",\"urlSplitIndex\":0}],\"codeStyle\":\"org.apache.dubbo.metadata.rest.springmvc.SpringMvcServiceRestMetadataResolver\",\"indexToName\":{0:[\"param\"]},\"method\":{\"annotations\":[],\"parameters\":[]},\"request\":{\"consumes\":[\"text/plain\"],\"headerNames\":[],\"headers\":{},\"method\":\"GET\",\"paramNames\":[\"param\"],\"params\":{\"param\":[\"{0}\"]},\"path\":\"/param\",\"produces\":[\"text/plain\"]}}",
            "{\"argInfos\":[{\"annotationNameAttribute\":\"map\",\"formContentType\":false,\"index\":0,\"paramAnnotationType\":\"org.springframework.web.bind.annotation.RequestBody\",\"paramName\":\"map\",\"paramType\":\"org.springframework.util.MultiValueMap\",\"urlSplitIndex\":0}],\"codeStyle\":\"org.apache.dubbo.metadata.rest.springmvc.SpringMvcServiceRestMetadataResolver\",\"indexToName\":{0:[\"map\"]},\"method\":{\"annotations\":[],\"parameters\":[]},\"request\":{\"consumes\":[\"application/x-www-form-urlencoded\"],\"headerNames\":[],\"headers\":{},\"method\":\"POST\",\"paramNames\":[],\"params\":{},\"path\":\"/multiValue\",\"produces\":[\"application/x-www-form-urlencoded\"]}}",
            "{\"argInfos\":[{\"annotationNameAttribute\":\"header\",\"defaultValue\":\"{0}\",\"formContentType\":false,\"index\":0,\"paramAnnotationType\":\"org.springframework.web.bind.annotation.RequestHeader\",\"paramName\":\"header\",\"paramType\":\"java.lang.String\",\"urlSplitIndex\":0}],\"codeStyle\":\"org.apache.dubbo.metadata.rest.springmvc.SpringMvcServiceRestMetadataResolver\",\"indexToName\":{0:[\"header\"]},\"method\":{\"annotations\":[],\"parameters\":[]},\"request\":{\"consumes\":[\"text/plain\"],\"headerNames\":[\"header\"],\"headers\":{\"header\":[\"{0}\"]},\"method\":\"GET\",\"paramNames\":[],\"params\":{},\"path\":\"/header\",\"produces\":[\"text/plain\"]}}"


        );

        ServiceRestMetadata springRestMetadata = new ServiceRestMetadata();
        springRestMetadata.setServiceInterface(service.getName());
        ServiceRestMetadata springMetadata = instance.resolve(service, springRestMetadata);


        List<String> jsonsTmp = new ArrayList<>();
        for (RestMethodMetadata restMethodMetadata : springMetadata.getMeta()) {
            restMethodMetadata.setReflectMethod(null);
            restMethodMetadata.setMethod(null);
            jsonsTmp.add(JsonUtils.toJson(restMethodMetadata));
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        jsons.sort(comparator);
        jsonsTmp.sort(comparator);


        for (int i = 0; i < jsons.size(); i++) {
            assertEquals(jsons.get(i), jsonsTmp.get(i));
        }

    }

    @Test
    void testDoubleCheck() {

        ServiceRestMetadata springRestMetadata = new ServiceRestMetadata();
        springRestMetadata.setServiceInterface(SpringRestServiceImpl.class.getName());
        ServiceRestMetadata springMetadata = instance.resolve(SpringRestServiceImpl.class, springRestMetadata);

        springMetadata.setContextPathFromUrl("context");

        Assertions.assertEquals("context", springMetadata.getContextPathFromUrl());

        springMetadata.setContextPathFromUrl("//context");
        Assertions.assertEquals("/context", springMetadata.getContextPathFromUrl());
        springMetadata.setPort(404);
        Map<PathMatcher, RestMethodMetadata> pathContainPathVariableToServiceMap = springMetadata.getPathContainPathVariableToServiceMap();

        for (PathMatcher pathMatcher : pathContainPathVariableToServiceMap.keySet()) {
            Assertions.assertTrue(pathMatcher.hasPathVariable());
            Assertions.assertEquals(404, pathMatcher.getPort());
        }


        Map<PathMatcher, RestMethodMetadata> pathUnContainPathVariableToServiceMap = springMetadata.getPathUnContainPathVariableToServiceMap();

        for (PathMatcher pathMatcher : pathUnContainPathVariableToServiceMap.keySet()) {
            Assertions.assertFalse(pathMatcher.hasPathVariable());
            Assertions.assertEquals(404, pathMatcher.getPort());
        }
    }
}