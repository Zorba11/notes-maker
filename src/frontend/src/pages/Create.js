import { Container, TextField, Typography } from '@material-ui/core';
import React from 'react';

const Create = () => (
  <Container>
    <Typography variant="h6" component="h2" color="textSecondary">
      Creat a New Note
    </Typography>
    <form noValidate autoComplete="off">
      <TextField
        label="Note Title"
        variant="outlined"
        color="secondary"
      ></TextField>
      <TextField></TextField>
    </form>
  </Container>
);
export default Create;
