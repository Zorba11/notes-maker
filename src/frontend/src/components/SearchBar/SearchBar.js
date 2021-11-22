import React, {useState} from 'react'
import './SearchBar.css'
import SearchIcon from '@material-ui/icons/Search';
import CloseIcon from '@material-ui/icons/Close';
import { useRecoilState } from 'recoil';
import { notesState } from '../../atoms/NotesState'

const SearchBar = ({ placeholder, data}) => {

  const [filteredData, setFilteredData] = useRecoilState(notesState);
  const [wordEntered, setWordEntered] = useState("");

  console.log("filtered..",filteredData)

  const handleFilter = (e) => {
    const searchString = e.target.value;
    setWordEntered(searchString);
    const newFilter = data.filter((value) => {
      return value.details.toLowerCase().includes(searchString.toLowerCase());
    })
    if(searchString === "") {
      setFilteredData([]);
    } else {
      setFilteredData(newFilter);
    }
  }

  const clearInput = () => {
    setFilteredData([]);
    setWordEntered("");
  }

  return (
    <div className="search">
      <div className="searchInputs">
        <input type="text" placeholder={placeholder} value={wordEntered} onChange={handleFilter}/>
        <div className="searchIcon">
          {wordEntered.length <= 0 ? <SearchIcon /> : <CloseIcon onClick={clearInput} id="clearBtn" />}
        </div>
      </div>
      {
        (filteredData.length > 0) ? (<div className="dataResult">
        {filteredData.slice(0, 15).map((value, key) => {
          return <a className="dataItem" href="#" target="_blank">
          {" "}
         <p> {value.details} </p>
          </a>
        })}
        </div>) : null
      }
    </div>
  )
}

export default SearchBar
