import { Card, CardContent, CardHeader, Typography } from '@material-ui/core';
import React from 'react';

const NoteCard = ({ note, handleDelete }) => {
  return (
    <div>
      <Card>
        <CardHeader title={note.title} subheader={note.category} />
        <CardContent>
          <Typography variant="body1" color="textSecondary">
            {note.details}
          </Typography>
        </CardContent>
      </Card>
    </div>
  );
};

export default NoteCard;
