import Vue from 'vue'
import Router from 'vue-router'
import mainpage from "../components/mainpage";
import ticketsearching from "../components/ticketsearching";
import profile from "../components/profile";
import singletrip from "../components/singletrip";
import twowaytrip from "../components/twowaytrip";
import trains from "../components/trains";
import suggestion from "../components/suggestion";
import p_orders from "../components/p_orders";
import p_info from "../components/p_info";


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'mainpage',
      component: mainpage,
      children:[{
        path:'',
        name:'ticketsearching',
        component:ticketsearching,
        children:[{
          path:'',
          name:'singletrip',
          component:singletrip
        },{
          path:'/singletrip',
          name:'singletrip',
          component:singletrip
        },{
          path:'/twowaytrip',
          name:'twowaytrip',
          component:twowaytrip
        },{
          path:'/trains',
          name:'trains',
          component:trains
        }]
      },{
        path:'/ticketsearching',
        name:'ticketsearching',
        component:ticketsearching,
        children:[{
          path:'',
          name:'singletrip',
          component:singletrip
        },{
          path:'/singletrip',
          name:'singletrip',
          component:singletrip
        },{
          path:'/twowaytrip',
          name:'twowaytrip',
          component:twowaytrip
        },{
          path:'/trains',
          name:'trains',
          component:trains
        }]
      },{
        path:'/profile',
        name:'profile',
        component:profile,
        children:[{
          path:'',
          name:'p_info',
          component:p_info,
        },{
          path:'/p_info',
          name:'p_info',
          component:p_info,
        },{
          path:'/p_orders/:o_type',
          name:p_orders,
          component:p_orders
        },{
          path:'/suggestion',
          name:'/suggestion',
          component:suggestion
        }]
      }
      ]
    }
  ]
})
