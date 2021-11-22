import {atom} from 'recoil';

const notesState = atom({
  key: 'username',
  default: {
    id: '',
        title: "",
        details: "",
        category: "",
        user: {
            id: 9,
            firstName: "",
            lastName: "",
            email: "",
        }
  }
})

export {notesState};