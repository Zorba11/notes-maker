import { Container } from '@material-ui/core';
import React, { useEffect } from 'react';
import { useState } from 'react';
import Masonry from 'react-masonry-css';
import NoteCard from '../components/NoteCard';

const Notes = () => {
  const [notes, setNotes] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8001/notes')
      .then((res) => res.json())
      .then((data) => setNotes(data));
  }, []);

  const handleDelete = async (id) => {
    await fetch('http://localhost:8001/notes' + id, {
      method: 'DELETE',
      headers: {
        content: 'application/json',
      },
    });
  };

  // grid items based on screen width- similar to having media query
  const breakpoints = {
    default: 3,
    1100: 2,
    700: 1,
  };

  return (
    <Container>
      <Masonry
        breakpointCols={breakpoints}
        className="my-masonry-grid"
        columnClassName="my-masonry-grid-column"
      >
        {notes.map((note) => (
          <div item key={note.id}>
            <NoteCard note={note} handleDelete={handleDelete} />
          </div>
        ))}
      </Masonry>
    </Container>
  );
};

export default Notes;
