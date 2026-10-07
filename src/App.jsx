import { useEffect, useState } from 'react'
import axios from 'axios'
import './App.css'
import Friends from './pages/Friends'
import GiftRecommend from './pages/GiftRecommend'
import ProductDetail from './pages/ProductDetail'
import Signup from './pages/Signup.jsx'
import Login from './pages/Login'
import ProductManage from './pages/ProductManage'
import Cart from './pages/Cart'
import Order from './pages/Order'
import GiftBox from './pages/GiftBox'
import Admin from './pages/Admin'
import MemberManage from './pages/MemberManage'
import OrderManage from './pages/OrderManage'
import MyPreference from './pages/MyPreference'
import SpringTest from './pages/SpringTest'

function App() {
  const [page, setPage] = useState('home')

  const [loginUser, setLoginUser] = useState(
    JSON.parse(localStorage.getItem('loginUser'))
  )

  const [friends, setFriends] = useState([])

  const handleLogin = (user) => {
    setLoginUser(user)
    setPage('home')
  }

  const handleLogout = () => {
    localStorage.removeItem('loginUser')
    setLoginUser(null)
    setFriends([])
    setPage('home')
  }

  useEffect(() => {
    if (loginUser) {
      loadFriends()
    } else {
      setFriends([])
    }
  }, [loginUser])

  const loadFriends = async () => {
    try {
      const friendResponse = await axios.get(
        'http://localhost:8080/api/friends',
        {
          params: {
            memberId: loginUser.memberId
          }
        }
      )

      const memberResponse = await axios.get(
        'http://localhost:8080/api/members'
      )

      const members = memberResponse.data

      const friendList = await Promise.all(
        friendResponse.data.map(async (friend) => {
          const member = members.find(
            (member) =>
              member.memberId === friend.friendMemberId
          )

          let preference = null

          try {
            const preferenceResponse =
              await axios.get(
                'http://localhost:8080/api/preferences',
                {
                  params: {
                    memberId: friend.friendMemberId
                  }
                }
              )

            preference = preferenceResponse.data
          } catch (error) {
            preference = null
          }

          return {
            ...friend,
            name: member ? member.name : '친구',
            birth: member ? member.birth : '',
            preference
          }
        })
      )

      setFriends(friendList)
    } catch (error) {
      setFriends([])
    }
  }

  const isAdmin =
    loginUser &&
    loginUser.role === 'ADMIN'

  return (
    <div className="app">

      {page !== 'signup' && page !== 'login' && (
        <header className="header">

          <h1>뭐든</h1>

          <div className="header-menu">

            {loginUser ? (
              <>
                <span>
                  {loginUser.name}님
                </span>

                <span onClick={handleLogout}>
                  로그아웃
                </span>
              </>
            ) : (
              <>
                <span onClick={() => setPage('signup')}>
                  회원가입
                </span>

                <span onClick={() => setPage('login')}>
                  로그인
                </span>
              </>
            )}

          </div>

        </header>
      )}

      {page !== 'signup' && page !== 'login' && (
        <div className="layout">

          <aside className="sidebar">

            <div
              className={
                page === 'home'
                  ? 'menu active'
                  : 'menu'
              }
              onClick={() => setPage('home')}
            >
              홈
            </div>

            <div
              className={
                page === 'friends'
                  ? 'menu active'
                  : 'menu'
              }
              onClick={() => setPage('friends')}
            >
              친구
            </div>

            <div
              className={
                page === 'cart'
                  ? 'menu active'
                  : 'menu'
              }
              onClick={() => setPage('cart')}
            >
              장바구니
            </div>

            <div
              className={
                page === 'giftBox'
                  ? 'menu active'
                  : 'menu'
              }
              onClick={() => setPage('giftBox')}
            >
              선물함
            </div>

            <div
              className={
                page === 'preference'
                  ? 'menu active'
                  : 'menu'
              }
              onClick={() => setPage('preference')}
            >
              내 취향
            </div>

            {isAdmin && (
              <>
                <div
                  className={
                    page === 'productManage'
                      ? 'menu active'
                      : 'menu'
                  }
                  onClick={() =>
                    setPage('productManage')
                  }
                >
                  상품관리
                </div>

                <div
                  className={
                    page === 'admin'
                      ? 'menu active'
                      : 'menu'
                  }
                  onClick={() =>
                    setPage('admin')
                  }
                >
                  관리자모드
                </div>
              </>
            )}

            <div
              className={
                page === 'springTest'
                  ? 'menu active'
                  : 'menu'
              }
              onClick={() => setPage('springTest')}
            >
              서버 연결 테스트
            </div>

          </aside>

          <main className="main-content">

            {page === 'home' && (
              <>
                <section className="welcome">

                  <p>
                    {loginUser
                      ? `반가워요, ${loginUser.name}님`
                      : '반가워요'}
                  </p>

                  <h2>
                    선물 고르기 어렵다면
                    <br />
                    뭐든에서 찾아보세요.
                  </h2>

                  <span>
                    친구의 취향을 확인하고
                    <br />
                    마음에 맞는 선물을 쉽게 골라보세요.
                  </span>

                </section>

                <section className="gift-box">

                  <p>선물하기</p>

                  <h2>
                    누구에게
                    <br />
                    선물할까요?
                  </h2>

                  <button
                    onClick={() => setPage('friends')}
                  >
                    친구에게 선물하기
                  </button>

                </section>

                <section className="birthday">

                  <h2>다가오는 생일</h2>

                  {friends.length === 0 ? (
                    <div className="friend-list">

                      <div className="friend">

                        <div className="friend-info">

                          <strong>
                            등록된 친구가 없습니다.
                          </strong>

                          <span>
                            친구를 등록하면 여기에 표시됩니다.
                          </span>

                        </div>

                      </div>

                    </div>
                  ) : (
                    <div className="friend-list">

                      {friends.map((friend) => (

                        <div
                          className="friend"
                          key={friend.friendId}
                        >

                          <div className="friend-info">

                            <strong>
                              {friend.name}
                            </strong>

                            <span>
                              친구
                            </span>

                            {friend.birth && (
                              <span>
                                {friend.birth}
                              </span>
                            )}

                          </div>

                          {friend.preference ? (
                            <span className="ready">
                              취향 준비됨
                            </span>
                          ) : (
                            <span className="ready">
                              취향 미등록
                            </span>
                          )}

                        </div>

                      ))}

                    </div>
                  )}

                </section>

                <section className="process">

                  <h2>뭐든 이용 방법</h2>

                  <div className="process-list">

                    <div className="process-item">

                      <strong>01</strong>

                      <h3>친구 선택</h3>

                      <p>
                        선물을 줄 친구를 선택합니다.
                      </p>

                    </div>

                    <div className="process-item">

                      <strong>02</strong>

                      <h3>취향 확인</h3>

                      <p>
                        친구가 등록한 취향을 확인합니다.
                      </p>

                    </div>

                    <div className="process-item">

                      <strong>03</strong>

                      <h3>선물 선택</h3>

                      <p>
                        추천된 상품 중 마음에 드는 선물을 선택합니다.
                      </p>

                    </div>

                  </div>

                </section>
              </>
            )}

            {page === 'friends' && (
              <Friends setPage={setPage} />
            )}

            {page === 'recommend' && (
              <GiftRecommend setPage={setPage} />
            )}

            {page === 'product' && (
              <ProductDetail setPage={setPage} />
            )}

            {page === 'cart' && (
              <Cart setPage={setPage} />
            )}

            {page === 'order' && (
              <Order setPage={setPage} />
            )}

            {page === 'giftBox' && (
              <GiftBox setPage={setPage} />
            )}

            {page === 'productManage' && isAdmin && (
              <ProductManage />
            )}

            {page === 'admin' && isAdmin && (
              <Admin setPage={setPage} />
            )}

            {page === 'memberManage' && isAdmin && (
              <MemberManage />
            )}

            {page === 'orderManage' && isAdmin && (
              <OrderManage />
            )}

            {page === 'preference' && (
              <MyPreference setPage={setPage} />
            )}

            {page === 'springTest' && (
              <SpringTest />
            )}

          </main>

        </div>
      )}

      {page === 'signup' && (
        <Signup setPage={setPage} />
      )}

      {page === 'login' && (
        <Login
          setPage={setPage}
          handleLogin={handleLogin}
        />
      )}

    </div>
  )
}

export default App