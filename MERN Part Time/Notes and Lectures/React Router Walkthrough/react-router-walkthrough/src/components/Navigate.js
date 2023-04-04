import {useNavigate} from 'react-router-dom';

const Navigate = (props) => {
  const navigate = useNavigate();

  const sendNav = (e) => {
    e.preventDefault();
    // When the user clicks the submit input, it will navigate to the /results path
    navigate("/results");
  }
}

export default Navigate