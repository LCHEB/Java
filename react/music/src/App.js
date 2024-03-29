import './App.css';
import { useState } from 'react';
import {BrowserRouter, Route, Link, Routes, useLocation, useNavigate} from 'react-router-dom';

function App() {
  //음악을 조회하고 등록하는 사이트를 구현하세요.
  //음악 조회는 / 에서
  //음악 등록은 /insert에서
  //음악 등록시 음악번호(숫자), 제목, 가수, 장르를 입력하여 등록
  //음악 번호는 중복되지 않게 입력해서 추가
  //음악 조회에서 음악 삭제버튼을 클릭하면 삭제되도록 구현 : 음악번호를 이용하여
  let [list, setList] = useState([]);
  
  function add(music){
    setList([music, ...list]);
  }
  function remove(num){
    let tmpList = list.filter(item=>item.num != num);
    setList(tmpList);
  }
  return(
    <BrowserRouter>
      <Nav/>
      <Routes>
        <Route path="/" exact element={<List list={list} add={add} remove={remove}/>} />
        <Route path="/add" element={<Add/>} />
      </Routes>
    </BrowserRouter>
  );
}
function Nav(){
  return(
    <ul className="menu-list">
      <li><Link to="/">음악 조회</Link></li>
      <li><Link to="/add">음악 추가</Link></li>
    </ul>
  )
}
function List ({list, add, remove}){
  const location = useLocation();

  let music = location.state;
  if(music != null){
    add(music);
    location.state = null;
  }
  return(
    <div>
      <h1>음악 리스트</h1>
      <table>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>가수</th>
            <th>장르</th>
            <th>기능</th>
          </tr>
        </thead>
        <tbody>
          {list.map((item)=>{
            return(
              <tr key={item.num}>
                <td>{item.num}</td>
                <td>{item.title}</td>
                <td>{item.singer}</td>
                <td>{item.genre}</td>
                <td><button onClick={()=>remove(item.num)}>삭제</button></td>
              </tr>
            )
          })}
        </tbody>
      </table>
    </div>
  );
}

function Add (){
  let [num , setNum] = useState(0);
  let [title, setTitle] = useState("");
  let [singer, setSinger] = useState("");
  let [genre, setGenre] = useState("");

  const navigate = useNavigate();
  
  function addMusic(){
    navigate("/", {
      state : {
        num,
        title,
        singer,
        genre
      }
    })
  }
  
  return(
    <div>
      <h1>음악 추가</h1>
      <label>음악 번호</label>
      <input type="number" placeholder="음악번호" onChange={(e)=>setNum(e.target.value)}/>
      <br/>
      <label>제목</label>
      <input type="text" placeholder="제목" onChange={(e)=>setTitle(e.target.value)}/>
      <br/>
      <label>가수</label>
      <input type="text" placeholder="가수" onChange={(e)=>setSinger(e.target.value)}/>
      <br/>
      <label>장르</label>
      <input type='text' placeholder="장르" onChange={(e)=>setGenre(e.target.value)}/>
      <br/>
      <button onClick={addMusic}>음악 추가</button>
    </div>
  );
}
export default App;
