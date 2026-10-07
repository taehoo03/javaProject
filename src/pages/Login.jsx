import { useState } from 'react'
import axios from 'axios'

function Login({ setPage, handleLogin }) {
  const [userId, setUserId] = useState('')
  const [password, setPassword] = useState('')

  const handleLoginSubmit = async () => {
    if (!userId || !password) {
      alert('아이디와 비밀번호를 입력해주세요.')
      return
    }

    try {
      const response = await axios.post(
        'http://localhost:8080/api/login',
        {
          userId,
          password
        }
      )

      const user = response.data

      if (!user) {
        alert('아이디 또는 비밀번호가 맞지 않습니다.')
        return
      }

      localStorage.setItem(
        'loginUser',
        JSON.stringify(user)
      )

      alert('로그인되었습니다.')

      handleLogin(user)
    } catch (error) {
      alert('로그인에 실패했습니다.')
    }
  }

  const handleKeyDown = (e) => {
    if (e.key === 'Enter') {
      handleLoginSubmit()
    }
  }

  return (
    <div className="login-page">
      <div className="login-box">
        <h2>로그인</h2>

        <p>뭐든에 로그인해주세요.</p>

        <div className="login-form">
          <label>아이디</label>

          <input
            type="text"
            value={userId}
            onChange={(e) => setUserId(e.target.value)}
            onKeyDown={handleKeyDown}
            placeholder="아이디를 입력해주세요."
          />

          <label>비밀번호</label>

          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            onKeyDown={handleKeyDown}
            placeholder="비밀번호를 입력해주세요."
          />

          <button onClick={handleLoginSubmit}>
            로그인
          </button>

          <button
            onClick={() => setPage('signup')}
          >
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

export default Login