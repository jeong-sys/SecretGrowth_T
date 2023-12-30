function registerUser() {
    event.preventDefault(); // 폼의 기본 제출 동작을 방지

    var formData = new FormData(document.getElementById('registrationForm'));

    fetch('/register', {
        method: 'POST',
        body: formData
    })
        .then(response => {
            if (response.ok) {
                return response.json(); // 서버로부터 JSON 응답을 받음
            } else {
                throw new Error('회원 가입 실패');
            }
        })
        .then(data => {
            console.log('Success:', data);
            alert('회원 가입이 완료되었습니다!'); // 성공 메시지 표시
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('회원 가입에 실패하였습니다.'); // 실패 메시지 표시
        });
}
