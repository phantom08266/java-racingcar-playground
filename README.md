## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

### 고려사항
1. position을 생성자로 받아서 음수체크만 하고 별다른 처리를 하지않는데,
    이렇게되면 어떤 생성자를 사용했느냐에 따라 position의 의미가 달라질 수 있는거 아닌가?
    
    내가 생각한 position의 의미는 해당 값을 기준으로 얼마나 이동했는가에 집중했음.
    그런데 생성자를 어떤걸 사용했느냐에 따라 동일 기준점이 아닌 기준이 변경될 수 있다고 판단했음.
    new Position(); new Position(5); 어떤건 시작위치가 0이고 다른건 5이니 
    이를 모르는 개발자가 잘못 쓸수 있지않나? 
    
    하지만 다시 생각해보니 Position클래스의 이름에 맞게 해당 Position클래스는 위치값에 신경만 써야지..
    라는 생각을 하게됨. new Position(3)일때 보통의 개발자는 해당 포지션이 3으로 설정되었구나 라고 인식하기 때문에
    너무 폐쇄적으로 해당 도메인에 맞게 클래스를 조작하는건 가독성에도 문제가 있을 것이라 판단함.
    
    결론 : 따라서 Position 클래스를 폐쇄적으로 해당 도메인에 맞는 커스텀 Position을 사용하려면 
    클래스 이름을 좀더 도메인에 맞게 작성해야하고, 그게아니면 통상적으로 사용하는 방식으로 가독성있게
    작성하는 것이 맞다 생각함.

2. @FunctionalInterface 는 함수형 인터페이스라는 것을 명시적으로 선언한 것!
   따라서 해당 애노테이션이 선언되어있으면 추상 메서드는 오직 하나여야 한다.
   하지만 자바 8부터 들어간 default 메서드는 괜찮다.
   default자체가 구현체가 이를 구현해도 되고 안해도 되는 optional같으므로!

3. Dto같은 클래스들은 Getter, Setter들을 허용하지만 도메인 클래스들은 객체에게 메시지를 보내는 형태로 개발하는것이 
   객체지향 코드를 작성하는 것이다.
   
4. CQRS 패턴 : Command Query Responsibility Segregation의 약자로 명령 조회 책임 분리 뜻이다.
   비즈니스가 복잡해짐에 따라 기존의 object로는 CRUD를 감당하기 힘들어졌다. 즉 데이터를 저장, 수정, 삭제
   하는 부분과 조회하는 모델이 달라질 수 있으므로 이를 분리하는 패턴을 말한다.<br>
   [배달의민족](https://www.youtube.com/watch?v=BnS6343GTkY), 
   [마틴파울러](https://martinfowler.com/bliki/CQRS.html), [번역](https://www.popit.kr/cqrs-eventsourcing/)
   
5. 