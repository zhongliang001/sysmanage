import Login from "./Login"
import Register from "./Register"
import Welcome from "./Welcome"
import Menu from "./pages/Menu"
import Dict from "./pages/Dict"
import Role from "./pages/Role"
import User from "./pages/User"
import Action from "./pages/Action"

const routes = [
  {
    name: "Login",
    path: "/login",
    component: Login
  },
  {
    name: "Register",
    path: "/register",
    component: Register
  },
  {
    name: "Welcome",
    path: "/welcome",
    component: Welcome,
    children: [
      {
        name: "菜单配置",
        path: "/menu",
        component: Menu
      },
      {
        name: "数据字典配置",
        path: "/dict",
        component: Dict
      },
      {
        name: "角色配置",
        path: "/role",
        component: Role
      },
      {
        name: "用户管理",
        path: "/user",
        component: User
      },
      {
        name: "菜单操作管理",
        path: "/action",
        component: Action
      }
    ]
  }

]

export default routes
