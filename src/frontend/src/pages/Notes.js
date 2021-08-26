import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { Container, Grid, Paper } from '@material-ui/core';
import NoteCard from '../components/NoteCard';
import Masonry from 'react-masonry-css';

export default function Notes() {
  const [notes, setNotes] = useState([]);
  const [networkError, setNetworkError] = useState('');

  useEffect(() => {
    fetch('api/v1/notes')
      .then((res) => res.json())
      .then((data) => {
        console.log('data', data)
        setNotes(data);
      })
  }, []);

  const handleDelete = async (id) => {
    await fetch('api/v1/notes/' + id, {
      method: 'DELETE',
      headers: {
        content: 'application/json',
      },
    });

    const newNotes = notes.filter((note) => note.id != id);
    setNotes(newNotes);
  };

  const breakpoints = {
    default: 3,
    1100: 2,
    700: 1,
  };

  return (
    <Container>
      {
        (notes.length < 1) ? <h2>You don't have any notes ! So, <Link to="/create">Create one</Link> 🙂 !</h2>
            :
            <Masonry
                breakpointCols={breakpoints}
                className="my-masonry-grid"
                columnClassName="my-masonry-grid_column"
            >
              {notes.map((note) => (
                  <div item key={note.id}>
                    <NoteCard note={note} handleDelete={handleDelete} />
                  </div>
              ))}
            </Masonry>
      }
    </Container>
  );
}
