import "./styles.css";
import Header from "./components/Header";
import Gallery from "./components/Gallery";
import { useState } from "react";
import AddPhoto from "./components/AddPhoto";

function App() {
  const [addPhotoForm, setAddPhotoForm] = useState<boolean>(false);
  const [label, setLabel] = useState<string>("");

  return (
    <>
      {addPhotoForm && (
        <div
          onClick={() => setAddPhotoForm(!addPhotoForm)}
          className="w-screen z-10 h-screen bg-opacity-25 bg-[#000] absolute"
        ></div>
      )}
      <Header
        label={label}
        setLabel={setLabel}
        addPhotoForm={addPhotoForm}
        setAddPhotoForm={setAddPhotoForm}
      />
      <main>
        {addPhotoForm && <AddPhoto />}
        <Gallery label={label} />
      </main>
    </>
  );
}

export default App;
