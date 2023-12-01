- 페어 매칭 기능
    - 페어매칭 조건
        - 미션을 수행할 페어 두 명씩 매칭
        - 페어 매칭 대상이 홀수일 때, 한 페어는 3 인으로 구성
        - 같은 레벨에서 이미 페어 맺은 짝은 다시 페어로 매칭될 수 없음
    - 구현 방법
        - 이름 목록을 `List\<String\>` 으로 준비
        - 목록의 순서를 랜덤으로 섞음
            -  `camp.nextstep.edu.missionutils.Randoms`의 shuffle 메서드를 활용
        - 홀수인 경우, 마지막 크루를 마지막 페어에 포함
        - 랜덤 목록에서 앞에서부터 순서대로 두 명씩 페어를 맺어줌
        - 같은 레벨에서 같은 페어가 다시 매칭되면, 크루 목록의 순서를 다시 랜덤으로 섞음
        - 3 회 시도까지 매칭이 되지 않거나, 매칭을 할 수 있는 경우의 수가 없다면 에러 메시지 출력

- [ ] 메인 기능 선택 기능
    - [X] 메인 기능 종류 출력 기능
    - [X] 메인 기능 종류 입력 기능
        - `camp.nextstep.edu.missionutils.Console`의 `readLine()`
    - 예외 처리
        - [ ] 잘못된 값 입력 시 예외 발생

- [ ] 페어 매칭 기능
    - [ ] 과정과 미션 출력하는 기능
    - [ ] 과정, 레벨, 미션 입력 기능
    - [ ] 페어 매칭 로직 기능
        - [ ] 목록 랜덤으로 섞는 기능
        - `camp.nextstep.edu.missionutils.Randoms`의 `shuffle` 메서드를 사용한 결과 순서대로 정렬
    - [ ] 페어 매칭 결과 출력 기능
    - [ ] **이미 매칭이력이 있는 값을 입력할 때** 페어 재매칭 기능
        - [ ] 안내 문구를 출력한 후, 재매칭 여부 입력 기능
        - [ ] 아니오를 선택할 시 ->  코스, 레벨, 미션을 다시 선택
        - [ ] 예를 선택할 시 재매칭 수행
    - 예외 처리
        - [ ] 과정, 레벨, 미션 양식과 다르면 예외 처리
        - [ ] 3 회 시도까지 매칭이 되지 않거나, 매칭을 할 수 있는 경우의 수가 없다면 예외 처리

- [ ] 페어 조회 기능
    - [ ] 과정과 미션 출력하는 기능
    - [ ] 과정, 레벨, 미션 입력 기능
    - [ ] 페어 매칭 결과 로드하여 출력하는 기능
    - [ ] 매칭 이력이 없다면, 매칭 이력 없다고 안내하는 기능
    - 예외 처리
        - [ ] 과정, 레벨, 미션 양식과 다르면 예외 처리
        - [ ] 조회할 페어 매칭 결과가 없다면 예외 처리

- [ ] 페어 초기화 기능
    - [ ] 초기화 성공 문구 출력 기능
    -
- [ ] `Q` 입력 시 종료