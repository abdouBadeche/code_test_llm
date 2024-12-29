const Progress = require("../models/Progress");

exports.updateProgress = async (req, res) => {
    const { userId, courseId, progress } = req.body;
    let userProgress = await Progress.findOne({ userId, courseId });

    if (userProgress) {
        userProgress.progress = progress;
        await userProgress.save();
    } else {
        userProgress = new Progress({ userId, courseId, progress });
        await userProgress.save();
    }

    res.status(200).json(userProgress);
};

exports.getProgress = async (req, res) => {
    const { userId, courseId } = req.query;
    const userProgress = await Progress.findOne({ userId, courseId });

    if (!userProgress) {
        return res.status(404).json({ message: "Progress not found" });
    }

    res.status(200).json(userProgress);
};