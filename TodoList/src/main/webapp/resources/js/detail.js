// 목록으로 버튼 클릭시 "/" 이동 (get 요청)
const goToList = document.querySelector("#goToList");

// 목록으로 버튼이 클릭된 경우
goToList.addEventListener("click", ()=>{
    // "/" 메인페이지 요청(get 방식)
    location.href = "/";
})

/* 
    location.href
        'http://localhost:8080/todo/detail?todoNo=1'
    location.pathname
        '/todo/detail'
    location.host
        'localhost:8080'
    location.search
        '?todoNo=1'
*/

// 할 일 상세 조회 페이지에서 쿼리스트링 값 얻어오기
// -> URL에서 얻어오면 된다

// location.search : 쿼리스트링만 얻어오기
// URLSearchParams() : 쿼리스트링을 객체 형태(key-value)로 다룰 수 있는 JS 객체
const todoNo = new URLSearchParams(location.search).get("todoNo");

// 완료 여부 변경
const completeBtn = document.querySelector("#completeBtn");
completeBtn.addEventListener("click", ()=>{
    // 현재 보고있는 Todo의 완료 여부를
    // O(true) <-> X(false) 변경 요청하기 (get 요청)
    location.href="/todo/complete?todoNo="+todoNo;
})
// 삭제 버튼
// 수정 버튼