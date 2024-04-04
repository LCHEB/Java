import './App.css';
import { useState } from 'react';
import {BrowserRouter, Route, Link, Routes, useLocation, useNavigate} from 'react-router-dom';

function App() {
  let [list, setList] = useState([]);
  
  function add(movie){
    setList([movie, ...list]);
  }
  function remove(id){
    let tmpList = list.filter(item=>item.id != id);
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
      <li><Link to="/">List</Link></li>
      <li className='mebu-item'><Link to="/add">Add New Movie</Link></li>
    </ul>
  )
}
function List ({list, add, remove}){
  const location = useLocation();

  let movie = location.state;
  if(movie != null){
    add(movie);
    location.state = null;
  }
  return(
    <div>
      <h1 className='title'>Movies</h1>
      <table className='table'>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Release Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {list.map((item)=>{
            return(
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.title}</td>
                <td>{item.genre}</td>
                <td>{item.release_date}</td>
                <td><button onClick={()=>remove(item.id)}>삭제</button></td>
              </tr>
            )
          })}
        </tbody>
      </table>
    </div>
  );
}

function Add (){
  let [id , setId] = useState(0);
  let [title, setTitle] = useState("");
  let [genre, setGenre] = useState("");
  let [release_date, setRelease_Date] = useState("");
  const navigate = useNavigate();
  
  function addMovie(){
    navigate("/", {
      state : {
        id,
        title,
        genre,
        release_date
      }
    })
  }
  
  return(
    <div>
      <h1 className='title2'>Create Movie</h1>
      <input type="number" className='input' placeholder="Input movie id" onChange={(e)=>setId(e.target.value)}/>
      <br/>
      <input type="text" className='input' placeholder="Input movie title" onChange={(e)=>setTitle(e.target.value)}/>
      <br/>
      <input type="text" className='input' placeholder="Input movie genre" onChange={(e)=>setGenre(e.target.value)}/>
      <br/>
      <label>출시일:</label>
      <input type='date' className='input-date' placeholder="연도-월-일" onChange={(e)=>setRelease_Date(e.target.value)}/>
      <br/>
      <button className='btn' onClick={addMovie}>Add Movie</button>
    </div>
  );
}
export default App;
