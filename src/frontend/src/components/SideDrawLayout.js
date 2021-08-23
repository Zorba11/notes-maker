import {
  AppBar,
  Avatar,
  Drawer,
  List,
  ListItem,
  ListItemIcon,
  ListItemText,
  makeStyles,
  Toolbar,
  Typography,
} from '@material-ui/core';
import {
  AddCircleOutlined,
  ExitToAppOutlined,
  SubjectOutlined,
} from '@material-ui/icons';
import { format } from 'date-fns';
import React from 'react';
import { useHistory, useLocation } from 'react-router-dom';

const drawerWidth = 240;

// automatically get access to the theme object when we
//  try to return a function in the makeStyle object, so we can
// inject the theme object and use its properties

const useStyle = makeStyles((theme) => {
  return {
    page: {
      background: '#e9ffd1',
      width: '100%',
      padding: theme.spacing(3),
    },
    drawer: {
      width: drawerWidth,
    },
    drawerPaper: {
      width: drawerWidth,
    },
    root: {
      display: 'flex',
    },
    active: {
      background: '#d7ffc2',
    },
    title: {
      padding: theme.spacing(2),
    },
    appbar: {
      width: `calc(100% - ${drawerWidth}px)`,
    },
    toolbar: theme.mixins.toolbar,
    date: {
      flexGrow: 1,
    },
    avatar: {
      marginLeft: theme.spacing(2),
    },
  };
});

const menuItems = [
  {
    text: 'My Notes',
    icon: <SubjectOutlined color="secondary" />,
    path: '/',
  },
  {
    text: 'Create Note',
    icon: <AddCircleOutlined color="secondary" />,
    path: '/create',
  },
  {
    text: 'Log out',
    icon: <ExitToAppOutlined color="secondary" />,
    path: '',
  },
];

const SideDrawLayout = ({ children }) => {
  const classes = useStyle();
  const history = useHistory();
  const location = useLocation();

  return (
    <div className={classes.root}>
      {/* app bar */}

      <AppBar className={classes.appbar} elevation={0}>
        <Toolbar>
          <Typography className={classes.date}>
            Today is {format(new Date(), 'do MMMM Y')}
          </Typography>
          <Typography>Mario</Typography>
          <Avatar src="/avatar.png" className={classes.avatar} />
        </Toolbar>
      </AppBar>

      {/* side drawer */}
      <Drawer
        className={classes.drawer}
        variant="permanent"
        anchor="left"
        classes={{ paper: classes.drawerPaper }}
      >
        <div>
          <Typography variant="h5" className={classes.title}>
            Ninja Notes
          </Typography>
        </div>

        {/* LIST/links */}

        <List>
          {menuItems.map((item) => (
            <ListItem
              button
              key={item.text}
              onClick={() => history.push(item.path)}
              className={location.pathname == item.path ? classes.active : null}
            >
              <ListItemIcon>{item.icon}</ListItemIcon>
              <ListItemText primary={item.text} />
            </ListItem>
          ))}
        </List>
      </Drawer>

      {/* contents of the page */}

      <div className={classes.page}>
        <div className={classes.toolbar}></div>
        {children}
      </div>
    </div>
  );
};

export default SideDrawLayout;
