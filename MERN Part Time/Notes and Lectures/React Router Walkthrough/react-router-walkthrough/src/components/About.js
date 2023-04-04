import {Link} from 'react-router-dom';

const About = (props) => {
  return(
    <div>
      <h1 style={{color:"blue"}}>
        About Component
      </h1>
      <Link to={"/"}>Go to Home</Link>
    </div>
  )
}

export default About