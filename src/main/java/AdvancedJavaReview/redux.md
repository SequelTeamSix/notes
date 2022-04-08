# Redux

- "A Predictable State Container for JS Apps"

A good fit for your react application when:

- more complex data flows
- displaying same data in multiple places
- large number of state changes to keep track of

#### Solving Problem of Shared State

1. [lift state](../03-handling-state/lifting-state.md) to a common ancestor - this can lead to a lot of redundant props, "prop drilling" - props end up being in a lot of components unnecessarily
   <img src="https://hackernoon.com/hn-images/1*A8ds6m4es9z3ZRWwbb2NXQ.png" alt="tree structure" />

- if we had the above component structure and component "Parent 2" had to share some common data with "Grand Child 2", there would be a lot of components that held this state that didn't need to

2. use [React Context](../04-advanced-react/context.md)

3. manage a global store using redux

- manage state change in one centralized place
- allows you to more easily handle complex data flows
- conducive to inter-component communication and non-hierarchical data
- leverages unidirectional data flow

## React: 3 Major Principles

1. One immutable store
2. State is read-only; the only way to change state is to emit an action
3. State is changed by pure functions

### Unidirectional Data Flow

- the data in your application continuously follows the same lifecycle pattern <img src="https://blog.novoda.com/content/images/2018/03/redux-architecture-overview.png" alt="unidirectional data flow">

1. Your code calls store.dispatch(action)

- this sends information to the store about the action that occurs
- the action itself is no more than a simple JavaScript object - it should include a "type" describing what kind of action is occurring, but otherwise the action structure is not strictly defined

```JavaScript
{type: 'CREATE_USER', user: {id:3, name:'Carl', email:'carl@gmail.com'}}
{type: 'FAVORITE_ITEM':, itemId: 12}
```

2. Redux calls the reducer function that you provide

- reducers are functions which calculate the new state of the store data, based on the previous state and the action provided
- these functions should be pure, meaning given the same input each time, they should always produce the same output (using something like a random function or making an ajax call would be impure)
- reducer functions take the previous state and the action which changes the state its parameters and calculate the new state - it's important here not to mutate the state directly but to return the new desired state

3. The redux store saves the completed state

- this state can be accessed by subscribing to the store and invoking the getState method (although we'll see shortly that we generally won't do that directly)

4. The change in state re-renders any relevant portion of the DOM

## Integrating Redux into Components

- we want our components to have the functionality to subscribe to our store, and retrieve/update the store's data
- we can include this functionality manually, writing a component with this behavior _or_ we can use react-redux to generate one for us
- the connect function is a high order component which wraps our components with this functionality
- doing so gives us access to a dispatch method via the component's props - dispatch allows us to dispatch an action to the store
- we can also define a mapStateToProps function that describes how to transfer the state in the redux store to the props available in the component
- if the container component is dispatching actions, a mapDispatchToProps function can be defined to describe the relationship in the other direction
- additionally, we need to provide the store to our application - this is typically done by wrapping the application in a Provider tag referencing the store

### Redux DevTools

- Redux provides helpful [developer tools](https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi?hl=en) which you can include in chrome and firefox to help monitor your store's state and changes to the store
- take a look at the [docs](https://github.com/zalmoxisus/redux-devtools-extension#installation) for configuring it with your application
