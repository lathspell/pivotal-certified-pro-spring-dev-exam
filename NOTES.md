Notes
=====

Project
=======

Progress
--------
chapter 4

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
    <context:property-placeholder location="db/datasource.properties"/>     // old for #{user}
    <util:properties id="db" location="db/datasource.properties"/>     // new, for #{db.user}
    ```

* Properties can be modified during loading by registering "PropertyEditors" to convert date formats etc.
* ApplicationContext can load configuration with the following prefixes:
    * no prefix - current working directory (works with src/main/resources, src/test/resources)
    * classpath: - within the current classpath
    * file: - absolute filename
    * http: - a network URL
* In XML configuration files, imports of other files with are possible with <import resource=...>

* The util: Namespace can help with defining Beans with
    * `<util:properties id=... location=...>` - to load Properties
    * `<util:constant static-filed=...>` - to inject a static field
    * `<util:map>, <util:list>, <util:set>` - to defined Collections
    * `<util:properties>` - to load Properties files
    
* The jdbc: Namespace can help with defining DataSource beans e.g. `<jdbc:embedded-database>`

* Configuration block inheritance (not identical to class inheritance!) can be archived
  with `<bean id=... parent=...>`

* Beans can be nested but Inner Beans can not be accessed from other outer beans. They can be used
  to create an anonymous object that only serves as a constructor parameter, though.

* Beans can get alias names by using `<alias name=... alias=...>` or providing a `<bean name=...` with
  several names separated by comma, semicolon or whitespace. The `id` and `name` tags of one bean 
  can be identical but it is not permitted to use the same identifier for several beans.  

* <context:annotation-config> activates detection for @PostConstruct, @PreDestroy, @Resource,
  @Autowired and @Required. <context:component-scan> additionally for @Component, @Service etc.
  The latter can be limited to packages for faster scanning.

* The `@Required` annotation forces the programmer to use a certain setter when creating a Bean

* `initMethod` can be private
* Use `@Import` to import @Configuration classes and `@ImportResource` to import XML configs
* Without `@ComponentScan` only @Configuration classes in the local package are found 

Spring Expression Language
--------------------------

In `@Value`, XML configurations and other places, the Spring Expression Language (SpEL) is used.
It's an enhancement of the Java EL which is used in e.g. JSP.
Examples: `#{dbProps.user}`, 

Context and Bean Lifecycle
--------------------------
The bean lifecycle is: Initialization, Use, Destruction
The context lifecycle can be described as:
* The ApplicationContext is initialized
* Bean definitions are loaded
* Bean definitions are processed (PropertyEditor, PropertyPlaceholderConfigurer etc.)
* Beans are instantiated
* Dependencies are injected
* Beans are processed
* Beans are used
* The ApplicationContext starts destruction
* Beans are destroyed

Bean lifecycle interceptors
---------------------------
* Using `<bean ... init-method=...>` in XML definition,
  implementing `InitializingBean` (deprecated) or
  using `@Bean(initMethod=...)` or
  using `@PostConstruct` on a method 
* Using `<bean ... destroy-method=...` in XML definition or
  implementing `DisposableBean` (deprecated) or
  using `@Bean(destroyMethod=...)` or
  using `@PreDestroy` on a method

Spring Bean Scopes
------------------
Compared with Java EE:
* Singleton - Only one object instance
* Prototype - Every Bean gets its own object instance
When using a Web application the following come along:
* Request - during the HTTP request
* Session - during the HTTP session
* global-session - during the global session of a "Portlet"
The "custom" scope is available for own scope implementations


