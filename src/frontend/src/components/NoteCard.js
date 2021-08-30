import React from 'react';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardContent from '@material-ui/core/CardContent';
import { Avatar, IconButton, makeStyles, Typography } from '@material-ui/core';
import { DeleteOutlined, EditOutlined } from '@material-ui/icons';
import { blue, green, pink, yellow } from '@material-ui/core/colors';
import Tilt from 'react-parallax-tilt';

const useStyles = makeStyles({
  avatar: {
    backgroundColor: (note) => {
      if (note.category.toLowerCase() == 'work') {
        return yellow[700];
      }
      if (note.category.toLowerCase() == 'financial') {
        return green[500];
      }
      if (note.category.toLowerCase() == 'todos') {
        return pink[500];
      }

      return blue[500];
    },
  },
});

const NoteCard = ({ note, handleDelete }) => {
  const classes = useStyles(note);
  console.log(note);

  return (
    <div>
      <Tilt tiltMaxAngleX={10} tiltMaxAngleY={10}>
        <Card elevation={3}>
          <CardHeader
            avatar={
              <Avatar className={classes.avatar}>
                {note.category[0].toUpperCase()}
              </Avatar>
            }

            action={
              <div>
                <IconButton>
                  <EditOutlined onClick={() => console.log("Hi from edit!")} />
                </IconButton>
                <IconButton>
                  <DeleteOutlined onClick={() => handleDelete(note.id)} />
                </IconButton>
              </div>
            }
            title={note.title}
            subheader={note.category}
          />
          <CardContent>
            <Typography variant="body2" color="textSecondary">
              {note.details}
            </Typography>
          </CardContent>
        </Card>
      </Tilt>
    </div>
  );
};

export default NoteCard;
