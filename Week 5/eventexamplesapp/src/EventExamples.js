import React from "react";

class EventExamples extends React.Component {

    constructor() {
        super();

        this.state = {
            count: 5
        };
    }

    increment = () => {
        this.setState({
            count: this.state.count + 1
        });
        this.sayHello();
    };

    decrement = () => {
        this.setState({
            count: this.state.count - 1
        });
    };

    sayHello = () => {
        alert("Hello Member!");
    };

    sayWelcome = (msg) => {
        alert(msg);
    };

    onPress = () => {
        alert("I was clicked");
    };

    render() {
        return (
            <div style={{ marginLeft: "30px", marginTop: "20px" }}>

                <h3>{this.state.count}</h3>

                <button
                    style={{ width: "90px", marginBottom: "5px" }}
                    onClick={this.increment}
                >
                    Increment
                </button>

                <br />

                <button
                    style={{ width: "90px", marginBottom: "5px" }}
                    onClick={this.decrement}
                >
                    Decrement
                </button>

                <br />

                <button
                    style={{ width: "90px", marginBottom: "5px" }}
                    onClick={() => this.sayWelcome("Welcome")}
                >
                    Say Welcome
                </button>

                <br />

                <button
                    style={{ width: "90px" }}
                    onClick={this.onPress}
                >
                    Click on me
                </button>

            </div>
        );
    }
}

export default EventExamples;