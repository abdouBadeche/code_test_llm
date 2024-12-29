const mongoose = require("mongoose");

const courseSchema = new mongoose.Schema({
    title: String,
    description: String,
    duration: Number, // Duration in hours
});

module.exports = mongoose.model("Course", courseSchema);