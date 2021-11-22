import React, { useEffect, useState } from 'react'
import { Container } from '@material-ui/core';
import Masonry from 'react-masonry-css';
import UserCard from '../components/UserCard';

const AllUsers = () => {
const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch('api/v1/users')
      .then((res) => res.json())
      .then((data) => { 
        console.log('data', data);
        setUsers(data);
      })
  }, [])

  const breakpoints = {
    default: 3,
    1100: 2,
    700: 1,
  };

  console.log(users);

  return (
    <Container>
      {
        (users.length < 1) ? <h2>There are no users yet !</h2>
        :
        <Masonry
          breakpointCols={breakpoints}
          className="my-masonry-grid"
          columnClassName="my-masonry-grid_column"
        >
        {
          users.map((user) => 
           ( <div item key={user.id}>
              <UserCard user={user}/>
            </div>)
          )
        }

        </Masonry>
      }
    </Container>
  )
}

export default AllUsers
