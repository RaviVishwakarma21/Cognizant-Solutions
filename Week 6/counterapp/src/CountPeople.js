import React from "react";

class CountPeople extends React.Component {

    constructor() {
        super();

        this.state = {
            entrycount: 0,
            exitcount: 0
        };
    }

    updateEntry() {
        this.setState((prevState) => {
            return {
                entrycount: prevState.entrycount + 1
            };
        });
    }

    updateExit() {
        this.setState((prevState) => {
            return {
                exitcount: prevState.exitcount + 1
            };
        });
    }

    render() {
        return (
            <div style={{ textAlign: "center", marginTop: "100px" }}>

                <button
                    style={{ backgroundColor: "lightgreen" }}
                    onClick={() => this.updateEntry()}
                >
                    Login
                </button>

                {" "}
                {this.state.entrycount} People Entered!!!

                <br /><br />

                <button
                    style={{ backgroundColor: "lightgreen" }}
                    onClick={() => this.updateExit()}
                >
                    Exit
                </button>

                {" "}
                {this.state.exitcount} People Left!!!
            </div>
        );
    }
}

export default CountPeople;