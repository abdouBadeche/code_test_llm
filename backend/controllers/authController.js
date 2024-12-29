const User = require("../models/User");
const jwt = require("jsonwebtoken");

exports.register = async (req, res) => {
    const { firstName, lastName, email, password } = req.body;
    const user = new User({ firstName, lastName, email, password });
    await user.save();
    const token = jwt.sign({ id: user._id }, "secret", { expiresIn: "1d" });
    res.status(201).json({ token });
};

exports.login = async (req, res) => {
    const { email, password } = req.body;
    const user = await User.findOne({ email });
    if (!user || user.password !== password) {
        return res.status(401).json({ message: "Invalid credentials" });
    }
    const token = jwt.sign({ id: user._id }, "secret", { expiresIn: "1d" });
    res.status(200).json({ token });
};