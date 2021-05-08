import Dashboard from "pages/Dashborad";
import Home from "pages/Home";      // json baseURL para não precisar do ./
import {BrowserRouter, Route, Switch} from "react-router-dom";

// Rotas de Navegação


const Routes = () => {      
    return (
        <BrowserRouter>
        <Switch>
            <Route path="/"exact>
                <Home/>
            </Route>
            <Route path="/dashboard">
                <Dashboard/>
            </Route>
        </Switch>
        </BrowserRouter>

      
    )
}

export default Routes;