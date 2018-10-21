Notes
=====

Project
=======

Progress
--------
Chapter 2, p34
TODO 3.

Links
-----
* https://www.cram.com/dashboard-flashcards#flashcards
* https://github.com/lathspell/pivotal-certified-pro-spring-dev-exam
* https://stackoverflow.com/questions/tagged/spring

Chapter 2 - Bean Lifecycle
==========================

Common Spring Dependencies:
----------------------------
* spring-core               - Fundamental Parts
* spring-beans              - Dependency Injection
* spring-context            - ApplicationContext für DI
* spring-context-support    - Integration mit Guava, FreeMarker etc.
* spring-expressions        - Spring Expression Language (SpEL)

Dependency Injection in XML
---------------------------

Mixing the Constructor and Beans Injection is possible.

* Constructor Injection
    ```
    <bean id=...>
        <constructor-arg ref/value=... index=...]>
    </bean>
    
    <bean id=... c:foo-ref=... c:bar=...>    // shortcuts for "constructor-arg"
    <bean id=... c:_0=... c:_1-ref=...>      // shortcuts with position numbers
    ```

* Beans Injection
    ```
    <bean id=...>
       <property name="foo" value=.../>
    </bean>

    <bean id=... p:foo-ref=... p:bar=...>     // shortcuts for "property"
    ```

* Properties laden
    ```
    <context:property-placeholder location="db/datasource.properties"/>
    ```

