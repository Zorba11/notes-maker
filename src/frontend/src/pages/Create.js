import {
  Button,
  Container,
  FormControl,
  FormControlLabel,
  FormLabel,
  makeStyles,
  Radio,
  RadioGroup,
  TextField,
  Typography,
} from '@material-ui/core';
import { KeyboardArrowRight } from '@material-ui/icons';
import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';

const useStyles = makeStyles({
  field: {
    marginTop: 20,
    marginBottom: 20,
    display: 'block',
  },
});

const Create = () => {
  const classes = useStyles();
  const history = useHistory();

  const [title, setTitle] = useState('');
  const [details, setDetails] = useState('');
  const [category, setCategory] = useState('work');
  const [titleError, setTitleError] = useState(false);
  const [detailsError, setDetailsError] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();

    setTitleError(false);
    setDetailsError(false);

    if (title === '') setTitleError(true);

    if (details === '') setDetailsError(true);

    if (title && details) {
      // fetch('http://localhost:8080/api/v1/notes', {
      //   method: 'POST',
      //   headers: {
      //     'Content-type': 'application/json',
      //   },
      //   body: JSON.stringify({ title, details, category }),
      // }).then(() => history.pushState('/'));

      console.log(title, details);
    }
  };

  return (
    <Container>
      <Typography variant="h6" component="h2" color="textSecondary">
        Creat a New Note
      </Typography>
      <form noValidate autoComplete="off" onSubmit={handleSubmit}>
        <TextField
          className={classes.field}
          onChange={(e) => setTitle(e.target.value)}
          error={titleError}
          label="Note Title"
          variant="outlined"
          color="secondary"
          fullWidth
          required
        ></TextField>
        <TextField
          className={classes.field}
          onChange={(e) => setDetails(e.target.value)}
          error={detailsError}
          label="Details"
          variant="outlined"
          color="secondary"
          fullWidth
          required
          multiline
          rows={5}
        ></TextField>

        <FormControl classes={classes.field}>
          <FormLabel>Note Category</FormLabel>
          <RadioGroup
            value={category}
            onChange={(e) => setCategory(e.target.value)}
          >
            <FormControlLabel
              value="reminders"
              control={<Radio />}
              label="Reminders"
            />

            <FormControlLabel value="todos" control={<Radio />} label="Todos" />

            <FormControlLabel
              value="financial"
              control={<Radio />}
              label="Financial"
            />

            <FormControlLabel value="work" control={<Radio />} label="Work" />
          </RadioGroup>
        </FormControl>

        <Button
          type="submit"
          color="secondary"
          variant="contained"
          endIcon={<KeyboardArrowRight />}
        >
          Submit
        </Button>
      </form>
    </Container>
  );
};

export default Create;
