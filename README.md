# Spring MVC DataTables Seed

![Screenshot](/README/spring-datatables.png)

```shell
$ mvn spring-boot:run
```

* [http://localhost:8080/index.html](http://localhost:8080/index.html)
* [http://localhost:8080/health](http://localhost:8080/health)
* [http://localhost:8080/env](http://localhost:8080/env)
* [http://localhost:8080/mappings](http://localhost:8080/mappings)
* [http://localhost:8080/metrics](http://localhost:8080/metrics)
* http://localhost:8080/webjars/jquery/1.11.3/jquery.js
* http://localhost:8080/webjars/datatables/1.10.9/js/jquery.dataTables.js

## Notes

> By default Spring Boot will serve static content from a directory called `/static` (or `/public` or `/resources` or
> `/META-INF/resources`) in the classpath or from the root of the `ServletContext`.

> In addition to the 'standard' static resources locations above, a special case is made for Webjars content.
> Any resources with a path `/webjars/**` will be served from jar files if they are packed in the Webjar format.

## Reference

* https://www.datatables.net/examples/basic_init/alt_pagination.html
* http://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html

## Read as a follow up to this exercise

* http://docs.spring.io/spring-boot/docs/1.2.7.RELEASE/reference/htmlsingle/#production-ready
