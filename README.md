# implementation-demo
Implementation demo codebase - for demonstrating usage through certain tasks.

## Requirements:
- Java 17+
- Selenium 3 latest or newer
- JUnit5 or TestNG
- Rest API: OkHttp3, Apache HTTP
- Logger: Slf4j, Log4j

These are some pre-agreed test cases with requirements separately available.

Log4j is using reload4j - security issues avoided.
Due to multiple bindings available, I use -Dslf4j.provider=X and choose the right binding.

For dependency handling, it's a maven project

I implemented the cases with Firefox. Easy enough to change/abstract, but not worth the time. 
## Usage
- mvn clean test
- run from IDE