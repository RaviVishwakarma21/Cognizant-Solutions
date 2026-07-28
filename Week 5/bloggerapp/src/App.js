import React from "react";

import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

import { books, blogs, courses } from "./Data";

import "./App.css";

function App() {

    return (

        <div className="container">

            <CourseDetails courses={courses} />

            <BookDetails books={books} />

            <BlogDetails blogs={blogs} />

        </div>

    );

}

export default App;