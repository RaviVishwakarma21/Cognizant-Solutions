import React from "react";

function Scorebelow70(props) {

    let players70 = [];

    props.players.map((item) => {
        if (item.score <= 70) {
            players70.push(item);
        }
        return null;
    });

    return (
        <div>
            {
                players70.map((item) => (
                    <li key={item.name}>
                        Mr. {item.name} {item.score}
                    </li>
                ))
            }
        </div>
    );
}

export default Scorebelow70;