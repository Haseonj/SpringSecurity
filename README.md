# SpringSecurity

 - Spring Configuration
     1. FilterChain을 이용하여 view에서 입력한 로그인 정보를 가로챈다.
     2. 가져온 정보를 UserDetailsService에 보낸다.
     3. 로그인이 성공 및 실패 시 작성된 url로 redirect 한다.
     4. 부가적인 기능으로 권한 부여 및 공격방지 활성화
     5. 비밀번호 암호화(빈으로 등록해두면 자동으로 처리된다.)
 - UserDetailsService
     1. 우선, JPA를 이용하여 아이디만 조회한다.
     2. 조회한 아이디가 있을 경우 해당 정보를 UserDetails에 저장한다.
 - CustomUserDetails
     1. User 정보를 저장하는 Value Object 개념
