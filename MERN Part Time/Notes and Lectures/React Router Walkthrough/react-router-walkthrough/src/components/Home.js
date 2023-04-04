import {Link} from 'react-router-dom';

const Home = (props) => {
  return(
    <div>
      <h1 style={{color:"red"}}>
        Home Component
      </h1>
      <Link to={"/about"}>Go to About</Link>
    </div>
    )
}

export default Home