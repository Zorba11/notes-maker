import React from 'react';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardContent from '@material-ui/core/CardContent';
import { Avatar, IconButton, makeStyles, Typography } from '@material-ui/core';
import { DeleteOutlined, EditOutlined } from '@material-ui/icons';
import Tilt from 'react-parallax-tilt';

const UserCard = ({ user }) => {
  // const classes = useStyles(note);

  let noteTitles = [];

  user.notes.forEach((note) => {
    noteTitles.push(note.title);
  })

  return (
    <div>
    <Tilt tiltMaxAngleX={10} tiltMaxAngleY={10}>
    <Card elevation={3}>
      <CardHeader
        avatar={
          <Avatar>
            {user.firstName.toUpperCase()}
          </Avatar>
        }

        action={
          <div>
            <IconButton>
              <EditOutlined onClick={() => console.log("Hi from edit!")} />
            </IconButton>
            <IconButton>
              <DeleteOutlined onClick={() => console.log('Hi from delete')} />
            </IconButton>
          </div>
        }
        title={user.firstName + user.lastName}
        subheader={user.email}
      />
      <CardContent>
        <Typography variant="body2" color="textSecondary">
         {user.notes.map(note => (note.title))}
        </Typography>
      </CardContent>
    </Card>
  </Tilt>
    </div>
  )
}

export default UserCard
