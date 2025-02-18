import axios from 'axios';

export const generateSecretSantaAssignments = async (employeesFile, previousAssignmentsFile) => {
  if (!employeesFile || !previousAssignmentsFile) {
    throw new Error("Please upload both files.");
  }

  const formData = new FormData();
  formData.append("employeesFile", employeesFile);
  formData.append("previousAssignmentsFile", previousAssignmentsFile);

  try {
    const response = await axios.post("http://localhost:8080/secret-santa/assign", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      responseType: "blob", 
    });

   
    const url = window.URL.createObjectURL(new Blob([response.data]));
    const link = document.createElement("a");
    link.href = url;
    link.setAttribute("download", "secret_santa_assignments.csv"); // Set the file name
    document.body.appendChild(link);
    link.click();
    link.remove();

    return { success: true };
  } catch (error) {
    console.error("Error during file upload or CSV download:", error);
    throw new Error("Error generating Secret Santa assignments.");
  }
};
