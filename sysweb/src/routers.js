import Login from "./Login";
import Register from './Register'
import Welcome from "./Welcome";
import Hi from "./pages/Hi";
import Hi2 from "./pages/Hi2";
import Menu from "./pages/Menu";
import Dict from "./pages/Dict";
import Role from "./pages/Role";

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
            },{
                name: '数据字典配置',
                path: '/dict',
                component: Dict
            },{
                name: '角色配置',
                path: '/role',
                component: Role
            }
        ]
    }

]

export default routes
