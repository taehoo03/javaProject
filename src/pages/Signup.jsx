import { useState } from 'react'

function Signup({ setPage }) {
  const [name, setName] = useState('')
  const [userId, setUserId] = useState('')
  const [password, setPassword] = useState('')
  const [phone, setPhone] = useState('')
  const [birth, setBirth] = useState('')
  const [address, setAddress] = useState('')
  const [detailAddress, setDetailAddress] = useState('')

  const handleSignup = () => {
    if (
      !name ||
      !userId ||
      !password ||
      !phone ||
      !birth ||
      !address
    ) {
      alert('필수 정보를 입력해주세요.')
      return
    }

    const user = {
      name,
      userId,
      password,
      phone,
      birth,
      address,
      detailAddress
    }

    localStorage.setItem('user', JSON.stringify(user))

    alert('회원가입이 완료되었습니다.')
    setPage('login')
  }

  return (
    <div className="signup-page">

      <div className="signup-box">

        <h2>회원가입</h2>
        <p>뭐든을 이용하기 위해 회원정보를 입력해주세요.</p>

        <div className="signup-form">

          <label>이름</label>

          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="이름을 입력해주세요."
          />

          <label>아이디</label>

          <input
            type="text"
            value={userId}
            onChange={(e) => setUserId(e.target.value)}
            placeholder="아이디를 입력해주세요."
          />

          <label>비밀번호</label>

          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="비밀번호를 입력해주세요."
          />

          <label>전화번호</label>

          <input
            type="text"
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
            placeholder="전화번호를 입력해주세요."
          />

          <label>생년월일</label>

          <input
            type="date"
            value={birth}
            onChange={(e) => setBirth(e.target.value)}
          />

          <label>주소</label>

          <input
            type="text"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
            placeholder="주소를 입력해주세요."
          />

          <label>상세주소</label>

          <input
            type="text"
            value={detailAddress}
            onChange={(e) => setDetailAddress(e.target.value)}
            placeholder="상세주소를 입력해주세요."
          />

          <button onClick={handleSignup}>
            회원가입
          </button>

          <button
            className="cancel-button"
            onClick={() => setPage('home')}
          >
            돌아가기
          </button>

        </div>

      </div>

    </div>
  )
}

export default Signup