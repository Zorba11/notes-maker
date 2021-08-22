import { Container } from '@material-ui/core';
import React, { useEffect } from 'react';
import { useState } from 'react';
import Masonry from 'react-masonry-css';

const Notes = () => {
  const [notes, setNotes] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8000/notes')
      .then((res) => res.json())
      .then((data) => setNotes(data));
  }, []);

  return (
    // <Container>
    //   <Masonry
    //     breakpointCols={breakpoints}
    //     className="my-masonry-grid"
    //     columnClassName="my-masonry-grid-column"
    //   >
    //     {notes.map((note) => (
    //       <div item key={note.id}></div>
    //     ))}
    //   </Masonry>
    // </Container>
    <div>
      {notes.map((note) => (
        <div>{note.title}</div>
      ))}
    </div>
  );
};

export default Notes;
