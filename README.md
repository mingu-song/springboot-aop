* annotation 사용
```java
@Around("@annotation(EnableRestCallLogs)")
...
@EnableRestCallLogs
```
* annotation 미사용
```java
@Around("within(mingu.spring.aop.controller.*)")
@Around("execution(public * mingu.spring.aop.controller.*.*(..))")
```
* 함수의 결과값이 필요하다면 Around 사용
* 필요없다면 Before, AfterRetuning, AfterThrowing 사용
---
* 개인적로는 annotation 방식이 명시적이고 좋아 보이지만(EnableRestCallLogAspect)
* 공통으로 처리해야 하는 것을 전파할때는 execution을 사용하여 모두 적용되게 하는 것이 좋아보임(PostCacheUpdateAspect)
* 참고
  * https://medium.com/@viniciusromualdobusiness/clean-architecture-with-spring-boot-a-good-idea-d6f97e450130