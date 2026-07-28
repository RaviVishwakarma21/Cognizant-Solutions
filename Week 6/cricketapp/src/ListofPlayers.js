import React from "react";

function ListofPlayers(props) {
    return (
        <div>
            {
                props.players.map((item) => (
                    <li key={item.name}>
                        Mr. {item.name} <span>{item.score}</span>
                    </li>
                ))
            }
        </div>
    );
}

export default ListofPlayers;