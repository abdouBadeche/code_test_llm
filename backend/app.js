const express = require("express");
const mongoose = require("mongoose");
const cors = require("cors");

const app = express();
app.use(cors());
app.use(express.json());

// Connect to MongoDB
mongoose.connect("mongodb://localhost:27017/meformer", {
    useNewUrlParser: true,
    useUnifiedTopology: true,
});

// Routes
app.use("/api/auth", require("./routes/auth"));
app.use("/api/courses", require("./routes/courses"));
app.use("/api/progress", require("./routes/progress"));

const PORT = 5000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));