import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Notes from './pages/Notes';
import Create from './pages/Create';
import { createTheme, ThemeProvider } from '@material-ui/core';
import { green, purple } from '@material-ui/core/colors';
import SideDrawLayout from './components/SideDrawLayout';

const theme = createTheme({
  palette: {
    secondary: green,
  },
  typography: {
    fontFamily: 'Oxygen',
    fontWeightLight: 500,
    fontWeightRegular: 700,
  },
});

function App() {
  return (
    <ThemeProvider theme={theme}>
      <Router>
        <SideDrawLayout>
          <Switch>
            <Route exact path="/">
              <Notes />
            </Route>
            <Route path="/create">
              <Create />
            </Route>
          </Switch>
        </SideDrawLayout>
      </Router>
    </ThemeProvider>
  );
}

export default App;
