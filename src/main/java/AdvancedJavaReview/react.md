# React 101

## React Core

-   Released in 2013
-   **What wass before react?**
    -   In 90s, early 2000s, we basically had HTML, JS & CSS
    -   Websites use to just have you click new links which would run new
    -   Mutltiple browsers required mutliple different implementations for websites to utilize more and more JS in webpages
    -   Eventually jQuery, allowed us to interact with the Document Object Model (DOM) across mutliple browsers
    -   JS was used to alter/update this DOM
-   What is a **Document Object Model(DOM)**?
    -   What the browser uses to display the webapp/website page
    -   Just the tree representation of the page
        -   Starting from the HTML tag, through the head and body, then through each individual element
-   This caused more and more massive websites to be released
-   We needed bigger libraries to organize the JS files
-   Birth of **Single Page Applications**
    -   Prior to SPA, we just had HTML files for each page and every time we moved to another page we would request from the server the html for the page desired
    -   This changed along with the JQuery and AJAX, this allowed us to have the JS file change/update our html file without requiring you to make calls to the server as a single HTML would just be edited using JS
-   With ever growing complexities with Frontend development it was becoming more difficult to find the bugs in code and understand how each part of the app was affected another
-   In 2013, React was released by Facebook to help improve their means of controlling and reducing complexity of multiple developers working on Frontend Development
    -   Used by large companies like Uber, Wix, Netflix, Walmart, etc...

## Declarative v Imperative

-   React says, Don't touch the DOM React will handle it.
    -   Many frameworks prior to react were responsible for directly manipulating the DOM
-   **Imperative**
    -   Imperative paradigm you directly change individuals parts of your app based on various user events
    -   Example:
        -   If user logged in, then updat the log-in function to show account, now show friends, display a chat, show favorited items....
    -   Becomes diffucult to see all related events and edge-casses
    -   Change an element on the page and reflow caused for expensive operations in these page developments
-   **Declarative**
    -   React introduced a more declarative paradigm approach where React makes the changes to the DOM by you giving it the components design and it will take a blueprint and actually build it for you
    -   You _never_ touch the DOM in React as it handles all changes for you
    -   Based on the state you declare, react will make the changes
        -   Example:
            -   If user logs in, you simply tell it what needs to change and react will automatically update the DOM
    -   All the states are accounted for in one place
    -   Resulted in less complexity, better code quality and faster build times
    -   React's name basically came from based on whatever the state(data) of the app is it will React and change everything for you to get the display you want

## Components

-   Building websites like lego-blocks
-   Built around re-usable components
-   Each of these individual pieces create this whole app
-   Components within Components withing Components
-   Each component can be easily copied over to other sections or projects
    -   Example: Look at Material UI, React Bootstrap, Blueprint
-   In simple term, these are just JS functions that receive some sort of input or attributes (props)
    -   Returns something that looks like html
-   Isn't exactly HTML as they are custom tags that have been set up to call and create specific html tags to manipulate the DOM as we expect

## One-way Data flow

-   Idea of **State** (data of our app) that works with our components using JavaScript Extension(JSX)
-   This React component (function) is used to create a Virtual DOM that gives react a blueprint of how it should update the actual DOM
-   Reac Will then look at the current website and look at the virtual DOM and change what's needed to make those changes present on the website
-   Uni-directional dataflow
-   Any time our website must change our _state_ must change as well

![React Data Flow](https://www.exploringreact.com/wp-content/uploads/2020/11/unidirectional.png)

-   Our application is built simply with the virtual dom
-   As soon as state changes it trickles down the app, making all the appropriate changes to all the elements down the DOM

![Virtual DOM Flow](https://lh4.googleusercontent.com/T-eAdGfboAHFuZ0jppyWzIVx92VPzp0p9HAHbaJ32VDnTeaGPkCh44EC4vIGKTJ7RGQ2H2AtaCIzDlqQ_Hh8EdAJVpdtk_6U5f0NuwypN85DzBQtvT5jOIX_7kMkxad3er0yVMPt)

## UI Library

-   React you can learn once and write anywhere
    -   Doesn't make assumptions about what technology stack you use
-   Uses the virtual DOM (blueprint) you provide and a robot to handle the UI changes
-   Now this allows the use of the main react blueprint you provide to React and if you give it to other version of the apps it can easily help edit the views in the app your using
    -   React Native
        -   iOS & Android Apps
    -   React 360
        -   VR Apps
    -   Electron & React Desktop
        -   React with Windows, MacOS & Linux Operration
    -   React blessed
        -   Terminal / Command Prompt
-   Projects import two libraries, React Core & React DOM

## 4 Main Concepts

1. React handles the changes to the actual DOM
2. Build using components (like lego bricks)
3. One-way data flow
4. Handles UI changes across multiple , just needs the blueprint

## Job of React Dev

-   Deciding what components to use?
-   Decide the state and where it lives
-   Determine what changes upon state change

# React Basic Start

-   There is a lot to be learned in the documentations
-   Installing a basic react app

```bash
# Creates a react app
npx create-react-app my-app
cd my-app
npm start
```

## Event Handling

-   React you can respond to events on the web page
-   Events include a bunch of things
    -   onClick
    -   onMouseover
    -   onKeyPress
    -   etc...
-   You attach an eventlistener/handler to an event on an element
-   Every Event handler function recieves an event object as its first parameter when it is called

```JavaScript
export default function GreetButton(){
    function helloPopUp(event = new Event()){
        console.log(event)
        alert("Welcome!!!!")
    }
    return(<button onClick={helloPopUp}>Click Me!</button>)
}
```

## Hooks

-   All components have a lifecycle
    -   created
    -   rendered
    -   rerendered
    -   componentDidMount
    -   componenetDidUpdate
-   Events that occur in the existence of a component
-   **Hooks** are functions that _hook_ into these lifecycle events to add additional functionality to our components

![Component Lifecycle](https://rangle.github.io/react-training/img/reactjs_component_lifecycle_functions.png)

```JavaScript
// some react provided hooks

const [user,setUser] = useState(); // adds statefulness to a component
const nameInput = useRef(); // consistent reference to an object in the DOM
useEffect(()=>{
    document.getElementByID("somethingheading").innerHtml = "What's up";
}); // Directly editing the DOM/WebPage outside of typical react Virtual Environment

// Redux Hooks
useSelector();
useDispatch();
```

```JavaScript
export default function Counter(){
    // [read-only value, functionToReplaceTheValue]
    const [num,setNum] = useState(0); // default value

    function addToNum(){
        const newValue = num + 1;
        setNum(newValue)
        // think of setNum as telling the react to RE-RENDER the component using the new value
    }
    return(<div>
        <h3>Counter Value {num} </h3>
       <button onClick={addToNum}>Add one to num</button>

    </div>)
}
```

## Axios

-   JavaScript Libray for making HTTP requests
-   It is one of the most popular JS libraries
-   Build on top of **AJAX**
    -   Asynchronous JavaScript and XML
        -   Terrible name because people almost never use AJAX to get XML and use JSON instead
-   Originally web pages had to completely reload whenever you made an HTTP request
    -   Poor user experience
-   AJAX allowed browsers to make HTTP requests and handle them in the JS
    -   Webpages could selectively update parts of their html
    -   HTTP requests did not force the entire page to reload

## React Routing

-   React is a SPA library
-   You can still have routing to emulate multiple pages
-   There is no in-built react router
    -   You have to use some 3rd party library
-   react-router is the one we used
-   Within a BrowserRouter tag you can have a Switch where you define Routes
    -   A user typing in that route in the URL will cause that component to render

```JavaScript

<Router>
    <Switch>
      <Route path='/create'>
        <CreateTaskPage></CreateTaskPage>
      </Route>

      <Route path='/view'>
        <TaskViewPage></TaskViewPage>
      </Route>
    </Switch>
</Router>
```

## Redux

-   **Flux** is a _design pattern_ developed by facebook
    ![Flux](https://miro.medium.com/max/1140/0*rovyUqYeojiAPHrX.png)

1. The **view** (react components people interact with) generates **actions**
2. These actions are sent to a **dispatcher**
3. Dispatcher updates the **store**
4. The store passes updated information to the view

-   Data flows in one direction

    -   The data flow is circular but the same direction

-   **Redux**
-   Redux is a _software_ that has a similar approach to flux but slightly different
    ![Redux](https://miro.medium.com/max/919/1*EdiFUfbTNmk_IxFDNqokqg.png)

1. The view generates some sort of **action**
2. This action sends a **dispatch mesage** to a **reducer function**
3. This reducer function interacts with a **store** to update the data within the store
4. Other components recieve information from that store

```JavaScript
// 1. Dispatch Messages
const dispatch = useDispatch();// hook that will allow a component to dispatch
    function addTask(){
        dispatch({type:"add", task:task})// message to send
    }

    return(<div>
        <button onClick={addTask}>Add Task</button>

    </div>)

// 2. Message sare revieved by the reducer function
    const reducer:Reducer<TaskState,any> = (taskState:TaskState = {tasks:[]}, message) =>{

    if(message.type === 'add'){
        const newTaskState:TaskState = {tasks:[...taskState.tasks,message.task]} // duplicating an array
        return newTaskState;
    }
    return taskState
}

// 3. Updates in the state that have selected from the store
const storeTasks:Task[] = useSelector((state:TaskState)=>state.tasks); // takes a
    const taskRows = storeTasks.map(t=>
    <tr><td>{t.name}</td>
    <td>{t.priority}</td>
    <td>{t.isComplete ? "Yes":"No"}</td>
    </tr>)

    return(<table>
        <thead><th>TaskName</th><th>Priority</th><th>Complete</th></thead>
        <tbody>
            {taskRows}
        </tbody>
    </table>)
}

```

# Redux Toolkit

-   Redux in its' bare form is quite simple and easy to understand, but adds a lot of boilerplate code which feels unnecessary and overcomplicates things
-   The Redux team came together to introduce the toolkit to help reduce this abundance of excess code
-   It's a Simple, Opinionated, Powerful and Effect (or SOPE) state management library
    -   Write more effecient code
    -   speed up development process
    -   Automatically apply the best practices
-   Solves 3 Major issues
    1. Configuring a redux store is too complicated
    2. Have to add a lot of packages to build a large scale app
    3. Too much boilerplate code which makes it cumbersome to write efficient and clean code

```bash
#Installing Redux toolkit
npm i @reduxjs/toolkit
```