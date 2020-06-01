# Clean Architecture SOLID by TDD
- 클린 아키텍쳐 책의 일부를 객체지향 설계원칙에 따라 테스트 주도 개발 방법론에 따라 예제를 작성한다.

사용 라이브러리
-----------
- Koin
- Hamcrest
- Mockito
- Espresso

SRP - Single Responsibility Principle 
=================
* 모듈의 변경의 이유는 하나여야한다.   

위반사례
------------------
![SRP Bad](https://github.com/kwcho7/tdd_solid/blob/master/srp/images/srp_bad.png?raw=true)

* 한명의 Actor의 요청에의한 변경으로 다른 Actor가 사용하는 Method가 영향 받을 수 있다.
* Employee Class 는 3가지의 변경 이유를 갖는다.   

Facade 패턴을 이용한 해결 방법 
-------------------
![SRP Facade](https://github.com/kwcho7/tdd_solid/blob/master/srp/images/srp_facade.png?raw=true)

* 분리된 Class 에 책임을 위임하여 변경요청에 대해 서로를 분리한다.
* Facade 패턴을 이용하여 외부로부터 정보를 감춘다.



OCP - Open Close Principle
=================
* 확장에는 열려있어야하고, 변경에는 닫혀있어야한다(1988년 버트란트 마이어)
* '행위는 확장할 수 있어야하지만 이때 변경에는 닫혀있어야한다'는 뜻이다.   

재무재표 분석기
------------------
* 요구사항 : 웹으로 보여지던 출력물을 종이 프린터로도 출력 가능해야한다.   

![Financial](https://raw.githubusercontent.com/kwcho7/tdd_solid/master/ocp/images/financial.png)
LSP- Liskov Substitution Principle
==========
![License](https://github.com/kwcho7/tdd_solid/blob/master/lsp/images/lsp_license.png?raw=true)

![Rectangle](https://github.com/kwcho7/tdd_solid/blob/master/lsp/images/lsp_rectangle.png?raw=true)

ISP
==========
TODO   

DIP
===========
TODO   

