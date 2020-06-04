# Clean Architecture SOLID by TDD
- 클린 아키텍쳐 책의 일부를 객체지향 설계원칙에 따라 테스트 주도 개발 방법론을 기반으로 예제를 작성한다.

사용 라이브러리
-----------
- Koin
- Hamcrest
- Mockito
- Espresso
   
[단일 책임 원칙 SRP](https://github.com/kwcho7/tdd_solid/tree/master/srp) - Single Responsibility Principle
=================
* 모듈의 변경의 이유는 하나여야한다.   

위반사례
------------------
* 한명의 Actor의 요청에의한 변경으로 다른 Actor가 사용하는 Method가 영향 받을 수 있다.
* Employee Class 는 3가지의 변경 이유를 갖는다.   

![SRP Bad](https://github.com/kwcho7/tdd_solid/blob/master/srp/images/srp_bad.png?raw=true)

Facade 패턴을 이용한 해결 방법 
-------------------
* 분리된 Class 에 책임을 위임하여 변경요청에 대해 서로를 분리한다.
* Facade 패턴을 이용하여 외부로부터 정보를 감춘다.

![SRP Facade](https://github.com/kwcho7/tdd_solid/blob/master/srp/images/srp_facade.png?raw=true)
   
[개방 폐쇠 원칙 OCP](https://github.com/kwcho7/tdd_solid/tree/master/ocp) - Open Close Principle
=================
* 확장에는 열려있어야하고, 변경에는 닫혀있어야한다(1988년 버트란트 마이어)
* '행위는 확장할 수 있어야하지만 이때 변경에는 닫혀있어야한다'는 뜻이다.   

재무재표 분석기
------------------
* 요구사항 : 웹으로 보여지던 출력물을 종이 프린터로도 출력 가능해야한다.   

![Financial](https://raw.githubusercontent.com/kwcho7/tdd_solid/master/ocp/images/financial.png)
리스코브 치환 원칙 LSP- Liskov Substitution Principle 
==========
* License 타입을 구현한 PersnalLicense와 BusinessLicense 가 있고 License 타입을 정의한 프로그램 Billing 에서 PersnalLicense 자리에 BusinessLicense 로 대체하더라도 Bulling 의 행위가 변하지 않아야한다.    
즉, 같은 부모를 상속, 구현한 객체는 다른 객체로 대체하더라도 부모를 사용하는 객체의 행위는 변하지 않아야한다.   

위반 사례
----------
* 정사각형은 직사각형을 상속받았다.   
* 정사각형은 넓이와 높이가 다를 수 있지만 정사각형은 넓이와 높이가같다.   
* 직사각형을 사용하는 사용자는 정사각형 대신 직사각형을 사용할 수 없다.   

![Rectangle](https://github.com/kwcho7/tdd_solid/blob/master/lsp/images/lsp_rectangle.png?raw=true)

인터페이스를 이용한 해결 
-----------
* Billing은 License 인퍼페이스를 참조하여 사용할때 PersonalLicense 나 BusinessLicense 둘중 어떤것을 사용하더라도 Billing 의 행동은 변경되지 않는다.

![License](https://github.com/kwcho7/tdd_solid/blob/master/lsp/images/lsp_license.png?raw=true)   

   

인터페이스 분리 원칙 ISP - Interface Segregation Principle
==========
* 다수의 Client 가 특정 Class의 각각의 Method를 사용한다면 각각 Method 는 분리되어야한다.

위반사례
----------
* User1, User2, User3 은 OPS Class 에 각각 ops1, ops2, ops3을 사용한다.
* User1은 ops1만 사용하는데도 ops2, ops3 에대한 의존성을 갖게된다.
   
![isp_bad](https://github.com/kwcho7/tdd_solid/blob/master/isp/images/isp_bad.png?raw=true)

인터페이스 분리를 이용한 해결방법 
-----------
* U1Ops, U2Ops, U3Ops 인터페이스를 이용하여 User1 은 U1Ops 의 ops1 method만 의존하여 사용하지 않는 method 에대한 의존성을 해결할 수 있다.
![isp](https://github.com/kwcho7/tdd_solid/blob/master/isp/images/isp.png?raw=true)



의존 역전 원칙 DIP - Dependency Inversion Principle
===========
* 추상화에 의존하고 구체에는 의존하지 않아야한다.
* 안정화된 플렛폼이나 안정적이며 변경되지 않은 코드에 대해서는 예외로 둘 수 있다.
* 추상화가 변하면 구체화 클레스도 변해야한다. 그러므로 최대한 인터페이스를 변경하지 않고도 구현체의 기능을 변경할 수단을 찾아야한다.
* 의존성의 방향이 양쪽이 서로 향하지 않도록 해야한다.(인터페이스, 팩토리 이용)   
![dip](https://github.com/kwcho7/tdd_solid/blob/master/dip/images/dip.png?raw=true)
