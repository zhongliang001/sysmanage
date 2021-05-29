import Login from "./Login";
import Register from './Register'
import Welcome from "./Welcome";
import Hi from "./pages/Hi";
import Hi2 from "./pages/Hi2";
import Menu from "./pages/Menu"

let routes = [
    {
        name: 'Login',
        path: '/login',
        component:  Login
    },
    {
        name: 'Register',
        path: '/register',
        component: Register
    },
    {
        name: 'Welcome',
        path: '/welcome',
        component:  Welcome,
        children: [
            {
                name: 'Hi',
                path: '/hi',
                component: Hi
            },
            {
                name: 'Hi2',
                path: '/hi2',
                component: Hi2
            },{
                name: '菜单配置',
                path: '/menu',
                component: Menu
            }
        ]
    }

]

export default routes
